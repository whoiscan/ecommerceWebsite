const initiailState={
    items:[]
}
export const cart=(state=initiailState,action)=>{
    switch (action.type) {
        case 'ADD_PRODUCT_TO_CART':
            return{
                items:[state.items,action.payload]

            }
        case 'DELETE_PRODUCT_FROM_CART':
            return{
                items:state.items.filter(id=>{return id!=action.payload})
            }
        default: return state
    }
}