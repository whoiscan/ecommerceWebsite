const initiailState={
    isReady:false,
    items:null
}
export const products=(state=initiailState,action)=>{
    switch (action.type) {
        case 'SET_PRODUCTS':
            return{
                ...state,
                items:action.payload,
                isReady: true
            }
        case 'SET_ISREADY':
            return{
                ...state,
               isReady: true
            }
        default: return state
    }
}