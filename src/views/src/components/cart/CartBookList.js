import CartBook from "./CartBook";


function CartBookList({userName}){

    return (
        <div>
            <CartBook userName={userName} />
        </div>
    );
}

export default CartBookList;