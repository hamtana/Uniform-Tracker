import axios from 'axios';

const API_BASE = "http://localhost:8080/api/inventory";

//Get the entire inventory
export const getInventory = () => axios.get(API_BASE);

export const updateQuantity = (inventoryid, quantity) =>
    axios.put(`${API_BASE}/${inventoryid}`, { quantity_in_stock: quantity});


