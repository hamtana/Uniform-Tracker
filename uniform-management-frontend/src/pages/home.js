import React from 'react';
import { Link } from 'react-router-dom';
import '../home.css'; //import css

function Home() {
  return (
    <div className="Home">
      <h1>Welcome</h1>
      <div className="centered-buttons">
        <Link to="/orders">
          <button>Orders</button>
        </Link>
        <Link to="/inventory">
          <button>Inventory</button>
        </Link>
      </div>
    </div>
  );
}

export default Home;
