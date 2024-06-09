import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import './Categories.css';

function Categories() {
    const [categorys, setCategorys] = useState([]);
    
    useEffect(() => {
        const getCategorys = async () => {
            try {
               const response = await fetch('http://localhost:8080/api/categories');
            const json = await response.json();
            setCategorys(json); 
            } catch (e) {
                console.error("백엔드 접속 에러", e);
            }
            
        };
        getCategorys();
    }, []);

    return (
        <div className="category-container">
            <div className="category-header-container">
                <h2 className="category-header">카테고리</h2>
                <span className="home-button"><Link to = {'/'}>홈</Link></span>
            </div>
            {
                categorys.length > 0 ? (

                    <ul className="category-list">
                {categorys.slice(0, 6).map((category, index) => (
                    <li key={index}>
                        <Link to={`/category/${category.categoryId}/books`}>{category.categoryName}</Link>
                    </li>
                ))}
                {categorys.length > 6 && (
                    <li>
                        <Link to="/categories">기타</Link>
                    </li>
                )}
            </ul>
                ) : <h2>카테고리가 없습니다.</h2>
            }
        </div>
    );
}

export default Categories;
