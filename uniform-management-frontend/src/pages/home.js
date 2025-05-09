import React from 'react';
import { Link } from 'react-router-dom';

function Home() {
  return (
    <div className="Home">
      <h1>Welcome</h1>
      <Link to="/orders">
        <button>Orders</button>
      </Link>
      <Link to="/inventory" style={{ marginLeft: '10px' }}>
        <button>Inventory</button>
      </Link>
    </div>
  );
}

export default Home;
