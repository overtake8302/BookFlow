import { Link, useHistory } from 'react-router-dom';
import SearchButton from "../../resources/home/header/Searchbutton.png";
import Logo from "../../resources/home/header/logo.jpg";
import MenuButton from "../../resources/home/header/menu.png";
import CartButton from "../../resources/home/header/Cart.png";
import UserButton from "../../resources/home/header/user.png";
import './HomeHeader.css';
import Logout from '../../routes/user/auth/logout';
import { useState, useEffect } from 'react';


function HomeHeader()  {
    const history = useHistory();
    // 장바구니: 로그인 안 했을 경우, 로그인 페이지로 이동
    const cartClick = () => {
        let userName = 'guest';
        const token = localStorage.getItem('token');
        if (token !== null){
            userName = localStorage.getItem('userName');
        }else{
            if(!localStorage.getItem('cart-guest')){
                localStorage.setItem(`cart-guest`, JSON.stringify([]));
            }
        }
        history.push(`/cart/${userName}`)
    };

    const [isRole, setIsRole] = useState();
    useEffect(() => {
        const checkRoleAccess = async () => {
          try {
            const token = localStorage.getItem('token');
            const response = await fetch(`${process.env.REACT_APP_API_URL}/api/auth/check`, {
              headers: {
                'access': token,
              }
            });
            const json = await response.json();
            const role = json.role;
            console.log("권한 : " + role);
            setIsRole(role);
          } catch (error) {
            console.error('Admin check failed:', error);
          }
        };
    
        checkRoleAccess();
      }, []);

    return(
        <div className="home-header">
            <div id="title">
                <Link to="/"><h1>BookFlow</h1></Link>
            </div>
            <div id="icons">
                <Link to="/search"><img src={SearchButton} /></Link>
                <img src={CartButton} onClick={cartClick} />
                {isRole !== "ROLE_ANONYMOUS" ? <Link to="/my"><img src={UserButton} /></Link> : null}
                <Logout />
                {isRole === "ROLE_ADMIN" ? <Link to="/admin/menu"><img src={MenuButton} /></Link> : null}
            </div>
        </div>
    );
}
export default HomeHeader;
