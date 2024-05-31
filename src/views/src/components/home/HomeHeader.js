import SearchButton from "../../resources/home/header/Searchbutton.png";
import MenuButton from "../../resources/home/header/menu.png";
import CartButton from "../../resources/home/header/Cart.png";
import UserButton from "../../resources/home/header/user.png";
import './HomeHeader.css';

function HomeHeader()  {
    return(
        <div className="home-header">
            <div id="title">
               <a href="/"><h1>Book</h1> </a>
            </div>
            <div id="icons">
                <a><img src={SearchButton} /></a>
                <a><img src={CartButton} /></a>
                <a><img src={UserButton} /></a>
                <a><img src={MenuButton} /></a>
            </div>
        </div>
    );
}
export default HomeHeader;