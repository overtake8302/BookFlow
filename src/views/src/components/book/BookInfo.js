

function BookInfo({img, title, detail, price, stock}){
    return (
        <div>
            <img src={img} />
            <div className="basic_info">
                {title}
                {detail}
                {price}
            </div>
            <div className="to_order">
                <div className="book-quantity">
                    <button>-</button>
                    <input
                        type="number"
                        value="1"
                        min="1"
                        max={stock}
                    />
                    <button>+</button>
                </div>
                <div className="order-cart-button">
                    <button>바로구매</button>
                    <button>장바구니</button>
                </div>
            </div>
        </div>
    );
}

export default BookInfo;