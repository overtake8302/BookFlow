import { Button } from '@chakra-ui/react';
import { withRouter } from 'react-router-dom';

function NoAccess({ history }) {
  const handleLoginRedirect = () => {
    history.push('/login');
  };

  return (
    <div>
      <h1>로그인이 필요해요</h1>
      <Button colorScheme="teal" onClick={handleLoginRedirect}>
        로그인 페이지로 가기
      </Button>
    </div>
  );
}

export default withRouter(NoAccess);
