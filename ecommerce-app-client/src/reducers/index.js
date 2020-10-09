import {combineReducers} from 'redux'
import {products} from "./products";
import {cart} from "./cart";

export default combineReducers({
    prods:products,
    cart:cart
})