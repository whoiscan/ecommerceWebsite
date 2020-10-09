// export const actionCart=(addOrDelete,product)=>{
//    const action= addOrDelete?{
//         type:'ADD_PRODUCT_TO_CART',
//         payload:product
//     }:{
//         type:'DELETE_PRODUCT_FROM_CART',
//         payload:product
//     }
//     return action;
// }
export  const deleteFromCart =(id)=>{
    return {
        type:'DELETE_PRODUCT_FROM_CART',
        payload:id
    }
}
export  const addToCart =(product)=>{
    return {
        type:'ADD_PRODUCT_TO_CART',
        payload:product
    }
}