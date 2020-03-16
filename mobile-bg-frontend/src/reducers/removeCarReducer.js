import { REMOVE_CAR_SUCCESS, REMOVE_CAR_ERROR } from '../containers/Home/types';

/** Store states
 * @constant {Object} */
export const initialState = {
  removeCarsError: '',

};

/** Remove Car reducer.
 * @param {Object} state - Initial state 
 * @param {Object} action - Payload object
 * @return {Object} - return new state
 */
function removeCarsReducer(state = initialState, action) {
  switch (action.type) {
    
    /** Action Creator - removeCar
    * it will receive response message 
    */
    case REMOVE_CAR_SUCCESS:
      return {
        ...state,
        removeCarsError:'',
      };

    /** Action Creator - Remove cars failed 
    * it will receive the error message  dispatching from the saga
    */
    case REMOVE_CAR_ERROR:
      return {
        ...state,
        removeCarsError: action.payload,
        
      };

    default:
      return state;
  }
}

export default removeCarsReducer;
