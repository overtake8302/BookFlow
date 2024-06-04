import HomeHeader from "../components/home/HomeHeader";
import Categories from "../components/home/Categories";
import Event from "../resources/home/event.jpg";
import Books from "../components/home/Books";
import Footer from "../components/home/Footer";
import './Home.css';

function Home() {
    return (
        <div className="container">
            <div>
                <HomeHeader />
            </div> 
            <div>
                <Categories />
            </div>
            <div>
                <img className="eventImg" src={Event} />
            </div>
            <div>
                <Books />
            </div>
            <div>
                <Footer />
            </div>
        </div>
        
      );
}
export default Home;