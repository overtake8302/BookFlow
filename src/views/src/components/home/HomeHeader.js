import { Link, useHistory } from 'react-router-dom';
import SearchButton from "../../resources/home/header/Searchbutton.png";
import Logo from "../../resources/home/header/logo.jpg";
import MenuButton from "../../resources/home/header/menu.png";
import CartButton from "../../resources/home/header/Cart.png";
import UserButton from "../../resources/home/header/user.png";
import './HomeHeader.css';
import Logout from '../../routes/user/auth/logout';
import { useState } from 'react';


function HomeHeader()  {
    const history = useHistory();
    // 장바구니: 로그인 안 했을 경우, 로그인 페이지로 이동
    const cartClick = () => {
        let userName = 'guest';
        const token = localStorage.getItem('token');
        if (token !== null){
            userName = localStorage.getItem('userName');
        }else{
            localStorage.setItem(`cart-guest`, JSON.stringify([]));
        }
        history.push(`/cart/${userName}`)
    };

    return(
        <div className="home-header">
            <div id="title">
                <Link to="/"><h1>BookFlow</h1></Link>
            </div>
            <div id="icons">
                <Link to="/search"><img src={SearchButton} /></Link>
                <img src={CartButton} onClick={cartClick} />
                <Link to="/login"><img src={UserButton} /></Link>
                <Logout />
                <Link to="/menu"><img src={MenuButton} /></Link>
            </div>
        </div>
    );
}
export default HomeHeader;
