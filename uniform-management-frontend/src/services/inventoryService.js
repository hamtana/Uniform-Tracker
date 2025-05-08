import axios from 'axios';

const API_BASE = "http:localhost:8080/api/inventory";

export const getInventory = () => axios.get(API_BASE);
export const updateQuantity = (id, quantity) =>
    axios.patch(`${API_BASE}/${id}`, { quantity_in_stock: quantity});


