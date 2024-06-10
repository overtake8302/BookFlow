import { useEffect, useState } from 'react';

const AdminUserList = () => {
  const[userList, setUserList] = useState();

  useEffect(()=>{
    fetch('http://localhost:8080/api/admin/member',{
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "access" : localStorage.getItem('access')
      },
    })
      .then(response => {
        return response.json()
      })
      .then(json =>{
        console.log(json);
        setUserList(prev => json)
      })
      .catch((error)=>{
        console.log(error);
      })
      return userList;
  }, [])  
  console.log(userList)
  return (


    <div>
      <div>관리자 페이지</div>
    </div>
  )
}

export default AdminUserList;