import HomeHeader from "../../components/home/HomeHeader";
import { useEffect, useState } from "react";
import ReactModal from 'react-modal';
import { Link } from "react-router-dom";
import { useParams } from 'react-router-dom';
import './OrderDetails.css';
function OrderDetails() {

<<<<<<< HEAD
=======
    const token = localStorage.getItem('token');


>>>>>>> 3bd465834f53b723681605371ce84809a3467005
    const [orderDetails, setOrderDetails] = useState();
    const {orderId} = useParams();
    const orderStatusKorean = {
        PAYMENT_COMPLETED: '결제 완료',
        SHIPPING: '배송 중',
        DELIVERED: '배송 완료',
        PREPARING_PRODUCT: '상품 준비 중'
      };

    const [name, setName] = useState("");
    const [phoneNumber, setPhonenumber] = useState("");
    const [address1, setAddress1] = useState("");
    const [address2, setAddress2] = useState("");
    const [orderRequest, setOrderRequest] = useState("");

    useEffect(() => {
<<<<<<< HEAD
        fetch(`http://localhost:8080/api/user/order/${orderId}`)
=======
        fetch(`http://localhost:8080/api/user/order/${orderId}`, {
            headers: {
                'access': token,
              }
        })
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
        .then((response) => {
            if (!response.ok) {
                throw new Error("Details 조회 에러");
            }
            return response.json();
        })
        .then((json) => {
            setOrderDetails(json);
            setName(json.orderDelivery.orderDeliveryReceiverName);
            setPhonenumber(json.orderDelivery.orderDeliveryReceiverPhoneNumber);
            setAddress1(json.orderDelivery.orderDeliveryAddress1);
            setAddress2(json.orderDelivery.orderDeliveryAddress2);
            setOrderRequest(json.order.orderRequest);
        })
        .catch((e) => (
            console.log("OrderDetails 조회에러", e)
        ))
    }, [orderId]);

    const handleUpdate = () => {
        const updatedDetails = {
            ...orderDetails,
            orderDto: {
                ...orderDetails.order,
                orderRequest: orderRequest
            },
            orderDeliveryDto: {
                ...orderDetails.orderDelivery,
                orderDeliveryReceiverName: name,
                orderDeliveryReceiverPhoneNumber: phoneNumber,
                orderDeliveryAddress1: address1,
                orderDeliveryAddress2: address2
            },
            orderItemDtos: [
                ...orderDetails.orderItems
            ]
        };
    
<<<<<<< HEAD
        // 업데이트된 데이터를 서버에 전송
        fetch(`http://localhost:8080/api/user/order/${orderId}`, {
            method: 'PUT',
            headers: {
=======
        fetch(`http://localhost:8080/api/user/order/${orderId}`, {
            method: 'PUT',
            headers: {
                'access': token,
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(updatedDetails)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('배송지 수정에 실패하였습니다.');
            }
            return response.json();
        })
        .then(data => {
            console.log('배송지 수정 성공', data);
        })
        .catch(error => {
            console.error('배송지 수정 실패', error);
        });
    };

    if (!orderDetails) {
<<<<<<< HEAD
        return "404 Not Found";
=======
        return (
            <div>
                <h1>주문 상세정보를 찾을수 없어요.</h1>
                <h2><Link to={"/orderList"}>주문내역을 찾으시나요?</Link></h2>
            </div>
            
        );
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
    }

    return (

        <div className="root">
            <div>
                <HomeHeader />
            </div>
            <h2>주문 상세정보</h2>
            <div className="order-item-container">
                {orderDetails.orderItems && orderDetails.orderItems.map((item) => (
                                <div className="order-item">
                                    {item.book ? (
                                            <div>
                                            <img src={item.book.img}></img>
                                            <span>{item.book.name}</span>
                                            <span>{item.orderItemPrice}원</span>
                                            <span>{item.orderItemQuantity}권</span>
                                            </div>
                                        )
                                        : (
                                            <div>
<<<<<<< HEAD
                                            <span>책 표지가 없습니다.</span>
                                            <span>책 이름이 없습니다.</span>
=======
                                            <span>책 표지가 없어요.</span>
                                            <span>책 이름이 없어요.</span>
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
                                            <span>{item.orderItemPrice}원</span>
                                            <span>{item.orderItemQuantity}권</span>
                                            </div>
                                        )
                                    }
                                </div>
                    ))}
            </div>
            <div>
                
            </div>
            {orderDetails.order && ( orderDetails.order.orderStatus == 'PAYMENT_COMPLETED' || orderDetails.order.orderStatus == 'PREPARING_PRODUCT') ? (
                <div className="formRootDiv">
                    <div className="orderStatusDiv">
                    <h3>상태: {orderStatusKorean[orderDetails.order.orderStatus]}</h3>
                    <h3 className="totalH3">합계: {orderDetails.order.orderTotalPrice}원</h3>
                    </div>
                    <h3 className="editH3">배송지 정보를 수정할 수 있어요.</h3>
                    <form className="form" onSubmit={handleUpdate}>
                        <h4>성함은 어떻게 되시나요?</h4>
                        <input 
                            type="text"
                            value={name}
                            onChange={(e) => setName(e.target.value)}
                            placeholder={name}
                        />
                        <h4>연락처를 알려주세요.</h4>
                        <input 
                            type="text"
                            value={phoneNumber}
                            onChange={(e) => setPhonenumber(e.target.value)}
                            placeholder={phoneNumber}
                        />
                        <h4>받으실 주소를 알려주세요.</h4>
                        <input 
                            type="text"
                            value={address1}
                            onChange={(e) => setAddress1(e.target.value)}
                            placeholder={address1}
                        /><br />
                        <input 
                            type="text"
                            value={address2}
                            onChange={(e) => setAddress2(e.target.value)}
                            placeholder={address2}
                        />
                        <h4>배송 메모를 적어주세요.</h4>
                        <input 
                            type="text"
                            value={orderRequest}
                            onChange={(e) => setOrderRequest(e.target.value)}
                            placeholder={orderRequest}
                        /><br />
                        <button type="submit">배송 정보 수정</button>
                    </form>
                </div>
<<<<<<< HEAD
                ) : (
                    <div>
                        <h3>배송이 시작되었어요.</h3>
                        <h4>배송정보를 수정할 수 없어요.</h4> 
                    </div>
                    
=======
                ) : orderDetails.order.orderStatus === 'SHIPPING' ? (
                        <div>
                            <h3>배송이 시작되었어요.</h3>
                            <h4>배송정보를 수정할 수 없어요.</h4>
                        </div>
                    ) : orderDetails.order.orderStatus === 'DELIVERED' && (
                        <div>
                            <h3>배송이 완료되었어요.</h3>
                        </div>
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
                )
            } 
        </div>
    );

}
export default OrderDetails;