import { Box, Text, Image, Input, Button, Link, useToast } from '@chakra-ui/react';
import { useEffect, useState } from "react";
import { useParams } from 'react-router-dom';
import HomeHeader from "../../components/home/HomeHeader";
// import './OrderDetails.css';

const token = localStorage.getItem('token');
const orderStatusKorean = {
  PAYMENT_COMPLETED: '결제 완료',
  SHIPPING: '배송 중',
  DELIVERED: '배송 완료',
  PREPARING_PRODUCT: '상품 준비 중'
};

function OrderDetails() {
    
  const toast = useToast(); 
  const [orderDetails, setOrderDetails] = useState();
  const { orderId } = useParams();
  const [formData, setFormData] = useState({
    name: '',
    phoneNumber: '',
    address1: '',
    address2: '',
    orderRequest: ''
  });
  

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  useEffect(() => {
    fetch(`${process.env.REACT_APP_API_URL}/api/user/order/${orderId}`, {
      headers: {
        'access': token,
      }
    })
    .then((response) => {
      if (!response.ok) {
        throw new Error("Details 조회 에러");
      }
      return response.json();
    })
    .then((json) => {
      setOrderDetails(json);
      setFormData((prev) => ({
        ...prev,
        name: json.orderDelivery.orderDeliveryReceiverName,
        phoneNumber: json.orderDelivery.orderDeliveryReceiverPhoneNumber,
        address1: json.orderDelivery.orderDeliveryAddress1,
        address2: json.orderDelivery.orderDeliveryAddress2,
        orderRequest: json.order.orderRequest
      }));
    })
    .catch((e) => {
      console.log("OrderDetails 조회에러", e);
    });
  }, [orderId]);

  const handleUpdate = async () => {
    try {
      const response = await fetch(`${process.env.REACT_APP_API_URL}/api/user/order/${orderId}`, {
        method: 'PUT',
        headers: {
          'access': token,
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
      });
  
      if (!response.ok) {
        throw new Error('배송지 수정에 실패하였습니다.');
      }
  
      const data = await response.json();
      console.log('배송지 수정 성공', data);
      toast({
        title: '배송정보를 잘 변경했어요.',
        status: 'success',
        duration: 5000,
        isClosable: true,
      });
      console.log('성공 토스트 호출 후');
    } catch (error) {
      console.error('배송지 수정 실패', error);
      toast({
        title: '배송정보변경을 실패했어요. 다시 시도해 주세요.',
        description: error.toString(),
        status: 'error',
        duration: 5000,
        isClosable: true,
      });
    }
  };
  

  if (!orderDetails) {
    return (
      <Box textAlign="center" py={10}>
        <Text fontSize="2xl">주문 상세정보를 찾을수 없어요.</Text>
        <Link to={"/order-list"}>주문내역을 찾으시나요?</Link>
      </Box>
    );
  }

  return (
    <Box className="root">
      <HomeHeader />
      <Text fontSize="xl" fontWeight="bold" my={5}>주문 상세정보</Text>
      <Box className="order-item-container">
        {orderDetails.orderItems && orderDetails.orderItems.map((item) => (
          <Box className="order-item" key={item.id}>
            {item.book ? (
              <Box>
                <Image src={item.book.bookImgList[0]?.imgUrl} alt={item.book.name} />
                <Text>{item.book.name}</Text>
                <Text>{item.orderItemPrice}원</Text>
                <Text>{item.orderItemQuantity}권</Text>
              </Box>
            ) : (
              <Box>
                <Text>책 표지가 없어요.</Text>
                <Text>책 이름이 없어요.</Text>
                <Text>{item.orderItemPrice}원</Text>
                <Text>{item.orderItemQuantity}권</Text>
              </Box>
            )}
          </Box>
        ))}
      </Box>
      {orderDetails.order && (orderDetails.order.orderStatus === 'PAYMENT_COMPLETED' || orderDetails.order.orderStatus === 'PREPARING_PRODUCT') ? (
        <Box className="formRootDiv">
          <Box className="orderStatusDiv">
            <Text>상태: {orderStatusKorean[orderDetails.order.orderStatus]}</Text>
            <Text className="totalH3">합계: {orderDetails.order.orderTotalPrice}원</Text>
          </Box>
          <Text className="editH3">배송지 정보를 수정할 수 있어요.</Text>
          <Box as="form" className="form" onSubmit={(event) => {
            event.preventDefault();
            handleUpdate();
            }}>
            <Text>성함은 어떻게 되시나요?</Text>
            <Input
              type="text"
              name="name"
              value={formData.name}
              onChange={handleInputChange}
              placeholder="성함을 입력해주세요"
            />
            <Text>연락처를 알려주세요.</Text>
            <Input
              type="text"
              name="phoneNumber"
              value={formData.phoneNumber}
              onChange={handleInputChange}
              placeholder="연락처를 입력해주세요"
            />
            <Text>받으실 주소를 알려주세요.</Text>
            <Input
              type="text"
              name="address1"
              value={formData.address1}
              onChange={handleInputChange}
              placeholder="주소를 입력해주세요"
            />
            <Input
              type="text"
              name="address2"
              value={formData.address2}
              onChange={handleInputChange}
              placeholder="상세 주소를 입력해주세요"
            />
            <Text>배송 메모를 적어주세요.</Text>
            <Input
              type="text"
              name="orderRequest"
              value={formData.orderRequest}
              onChange={handleInputChange}
              placeholder="배송 메모를 입력해주세요"
            />
            <Button type='submit'>배송 정보 수정</Button>
          </Box>
        </Box>
      ) : orderDetails.order.orderStatus === 'SHIPPING' ? (
        <Box>
          <Text>배송이 시작되었어요.</Text>
          <Text>배송정보를 수정할 수 없어요.</Text>
        </Box>
      ) : orderDetails.order.orderStatus === 'DELIVERED' && (
        <Box>
          <Text>배송이 완료되었어요.</Text>
        </Box>
      )}
    </Box>
  );
}

export default OrderDetails;
