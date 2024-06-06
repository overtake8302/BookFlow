import HomeHeader from "../../components/home/HomeHeader";
import { useEffect, useState } from "react";
import ReactModal from 'react-modal';
import { Link } from "react-router-dom";
import './OrderList.css';

<<<<<<< HEAD
const customStyles = {
    content: {
      top: '50%',
      left: '50%',
      right: 'auto',
      bottom: 'auto',
      marginRight: '-50%',
      transform: 'translate(-50%, -50%)'
    }
  };
  
  ReactModal.setAppElement('#root');

const orderStatusKorean = {
    PAYMENT_COMPLETED: '결제 완료',
    SHIPPING: '배송 중',
    DELIVERED: '배송 완료',
    PREPARING_PRODUCT: '상품 준비 중'
  };

function OrderList() {

=======
function OrderList() {

    const token = localStorage.getItem('token');
    console.log(localStorage.getItem('token'))

    const customStyles = {
        content: {
        top: '50%',
        left: '50%',
        right: 'auto',
        bottom: 'auto',
        marginRight: '-50%',
        transform: 'translate(-50%, -50%)'
        }
    };
    
    ReactModal.setAppElement('#root');

    const orderStatusKorean = {
        PAYMENT_COMPLETED: '결제 완료',
        SHIPPING: '배송 중',
        DELIVERED: '배송 완료',
        PREPARING_PRODUCT: '상품 준비 중'
    };

>>>>>>> 3bd465834f53b723681605371ce84809a3467005
    const [modalIsOpen, setModalIsOpen] = useState(false);

    const [selectedOrderId, setSelectedOrderId] = useState(null);

    function openModal(orderId) {
      setSelectedOrderId(orderId);
      setModalIsOpen(true);
    }
  
    function closeModal() {
      setModalIsOpen(false);
    }

    function formatDate(date) {
        const options = { year: 'numeric', month: '2-digit', day: '2-digit' };
        return new Date(date).toLocaleDateString('ko-KR', options).replace(/\./g, ' -').slice(0, -1);
    }

    function cancelOrder() {
        fetch(`http://localhost:8080/api/user/order/${selectedOrderId}`, {
<<<<<<< HEAD
            method: 'delete'
=======
            method: 'delete',
            headers: {
                'access': token,
              }
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
        })
        .then((response) => {
            if (!response.ok) {
                throw new Error('주문 취소 실패');
            }
<<<<<<< HEAD
            setOrderList((list) => list.filter((order) => order.orderId !== selectedOrderId));
=======
            setOrderList((list) => list.filter((order) => order.orderId !== selectedOrderId), () => {
                closeModal();
                fetchOrderList();
            });
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
            closeModal();
            fetchOrderList();
        })
        .catch((e) => (
            console.log('주문 취소 실패', e)
        ));
    }

    const [orderList, setOrderList] = useState();

    function fetchOrderList() {

<<<<<<< HEAD
        fetch("http://localhost:8080/api/user/orders")
        .then((response) => {
          if (!response.ok) {
            throw new Error("ordereList 조회 에러");
=======
        fetch("http://localhost:8080/api/user/orders", {
            headers: {
                'access': token,
              }
        })
        .then((response) => {
          if (!response.ok) {
            throw new Error("ordereList 조회 에러1");
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
          }
          return response.json();
        })
        .then((json) => setOrderList(json.orderList))
<<<<<<< HEAD
        .catch((e) => console.log("orderList 조회에러", e));
    }

    useEffect(() => {
        fetch("http://localhost:8080/api/user/orders")
        .then((response) => {
            if (!response.ok) {
                throw new Error("ordereList 조회 에러");
=======
        .catch((e) => console.log("orderList 조회에러1", e));
    }

    useEffect(() => {
        fetch("http://localhost:8080/api/user/orders", {
            headers: {
                'access': token,
              }
        })
        .then((response) => {
            if (!response.ok) {
                throw new Error("ordereList 조회 에러2");
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
            }
            return response.json();
        })
        .then((json) => (setOrderList(json.orderList)))
        .catch((e) => (
<<<<<<< HEAD
            console.log("orderList 조회에러", e)
        ))
    }, [modalIsOpen]);

    if (!orderList) {
=======
            console.log("orderList 조회에러2", e)
        ))
    }, [modalIsOpen]);

    if (!orderList || orderList.length == 0) {
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
        return (
            <div className="container">
              <HomeHeader />
              <h2>주문하신 내역이 없어요.</h2>  
            </div>
            
        )
    }

    return (
        <div className="container">
           <HomeHeader/> 

           <h1>결제하신 내역이에요.</h1>
            <div>
            <table>
<<<<<<< HEAD
                <thead>
=======
                <thead className="thead">
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
                    <tr>
                        <th>주문일</th>
                        <th>주문정보</th>
                        <th>결제 금액</th>
                        <th>상태</th>
                        <th>주문취소</th>
                    </tr>
                </thead>
                <tbody>
                    {orderList.map((list) => (
                        <tr>
                            <td>{formatDate(list.order.createdAt)}</td>
                            <td><Link className = 'link' to = {`orderDetails/${list.order.orderId}`}>{list.order.orderSummaryTitle}</Link></td>
                            <td>{list.order.orderTotalPrice}</td>
                            <td>{orderStatusKorean[list.order.orderStatus]}</td>
<<<<<<< HEAD
                            <td><button onClick={() => openModal(list.order.orderId)}>주문취소</button></td>
=======
                            <td> { list.order.orderStatus !== 'SHIPPING' && list.order.orderStatus !== 'DELIVERED' && (
                                <button className="cancelBtn" onClick={() => openModal(list.order.orderId)}>주문취소</button>
                            )}</td>
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
            
            
            <ReactModal
            isOpen={modalIsOpen}
            onRequestClose={closeModal}
            style={customStyles}
            contentLabel="주문 취소 확인"
            >
<<<<<<< HEAD
            <h2>주문을 취소하시겠습니까?</h2>
            <button onClick={cancelOrder}>예</button>
            <button onClick={closeModal}>아니요</button>
=======
            <h2>주문을 취소하실건가요?</h2>
            <button className="yesBtn" onClick={cancelOrder}>네, 취소할게요.</button><br />
            <button className="noBtn" onClick={closeModal}>아니요, 다시생각해 볼게요.</button>
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
            </ReactModal>
        </div>
        
    );
}
export default OrderList;