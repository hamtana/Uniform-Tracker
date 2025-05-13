import React from 'react';

//Search Bar Component
export default function SearchBar({searchTerm, onSearch}){
    return(
        <input type="text" placeholder="Search by Name..." value={searchTerm} onChange={(e) => onSearch(e.target.value)}
        style={{ padding: '8px', width: '300px', marginBottom: '20px' }} />
    );
}