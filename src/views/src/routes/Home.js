import HomeHeader from "../components/home/HomeHeader";
import Categorys from "../components/home/Categorys";
import Event from "../resources/home/event.jpg";

function Home() {
    return (
        <div>
            <div>
                <HomeHeader />
            </div> 
            <div>
                <Categorys />
            </div>
            <div>
                <img src={Event} />
            </div>
        </div>
        
      );
}
export default Home;