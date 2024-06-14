import React, { useState } from 'react';
import SearchResult from './SearchResult';

const SearchPage = () => {
  const [keyword, setKeyword] = useState('');

  const handleInputChange = (event) => {
    setKeyword(event.target.value);
  };

  return (
    <div>
      <input
        type="text"
        value={keyword}
        onChange={handleInputChange}
        placeholder="책 검색..."
      />
      <SearchResult keyword={keyword} />
    </div>
  );
};

export default SearchPage;
