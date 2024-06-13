
function BookInfoDetail({category, parentCategory}){
    return (
        <div>
            <h3>관련 분류</h3>
            {parentCategory} > {category}
        </div>
    );
}

export default BookInfoDetail;