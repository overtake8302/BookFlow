import React, { useState } from 'react';
import HomeHeader from "../components/home/HomeHeader";
import Categories from "../components/home/Categories";
import Event from "../resources/home/event.png";
import Books from "../components/home/Books";
import Footer from "../components/home/Footer";
import BannerSlider from "../components/home/BannerSlider";
import './Home.css';
import { ChakraProvider } from "@chakra-ui/react";

function Home() {
    const [activeCategory, setActiveCategory] = useState('홈');

    return (
        <div className="container">
            <div>
                <ChakraProvider>
                    <HomeHeader />
                </ChakraProvider>
            </div>
            <div>
                <Categories 
                    activeCategory={activeCategory} 
                    setActiveCategory={setActiveCategory} 
                />
            </div>
            <div>
                <BannerSlider />
            </div>
            <div>
                <ChakraProvider>
                <Books />
                </ChakraProvider>
            </div>
            <div>
                <Footer />
            </div>
        </div>
    );
}

export default Home;
