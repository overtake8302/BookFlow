import "./CartHeader.css";
import {useState} from "react";

function CartHeader(){
    //전체선택
    const [checkAll, setCheckAll] = useState(false);
    const CheckAll = () => {
        setCheckAll((prev) => !prev);
        // 각 상품 체크 여부 바꾸는 코드
    }

    //전체삭제
    const deleteAll = () => {
        // 삭제 코드
    }

    //선택삭제
    const deleteChecked = () => {
        // 삭제 코드
    }

    return (
        <div>
            <h2>장바구니</h2>
            <div className="check-delete">
                {/* 전체 선택 체크박스 */}
                <input
                    id="checkAll"
                    type="checkbox"
                    onChange={CheckAll}
                />
                <label htmlFor="checkAll"> 전체선택</label>
                <button
                    className="delete"
                    onClick={deleteAll}
                >
                    전체삭제
                </button>
                <button
                    className="delete"
                    onClick={deleteChecked}
                >
                    선택삭제
                </button>
            </div>
        </div>
    );
}

export default CartHeader;