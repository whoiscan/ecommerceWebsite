export const setProducts=(addOrDelete,product)=>{
   const action= addOrDelete?{
        type:'ADD_PRODUCT',
        payload:product
    }:{
        type:'DELETE_PRODUCT',
        payload:product
    }
    return action;
}