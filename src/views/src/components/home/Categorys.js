import { useState, useEffect } from "react";
import { Link } from "react-router-dom"; // react-router-dom 라이브러리의 Link 컴포넌트를 사용

function Categorys() {
    const [categorys, setCategorys] = useState([]);
    
    useEffect(() => {
        const getCategorys = async () => {
            const response = await fetch('http://localhost:8080/api/category');
            const json = await response.json();
            setCategorys(json);
        };
        getCategorys();
    }, []);

    return (
        <div>
            <h2>카테고리</h2>
            <ul>
                {categorys.slice(0, 6).map((category, index) => (
                    <li key={index}>
                        <Link to={`/category/${category.category_id}`}>{category.category_name}</Link>
                    </li>
                ))}
                {categorys.length > 6 && (
                    <li>
                        <Link to="/category">기타</Link>
                    </li>
                )}
            </ul>
        </div>
    );
}

export default Categorys;
