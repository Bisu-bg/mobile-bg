import { REDIRECT } from '../components/CustomRedirect/types';

/** Store states
 * @constant {Object} */
export const initialState = {
  redirect: ''
};

/** Redirect Reducer.
 * @param {Object} state - Initial state 
 * @param {Object} action - Payload object
 * @return {Object} - return new state
 */
function redirectReducer(state = initialState, action) {
  switch (action.type) {
    /** Action Creator - Redirect to passed screen */
    case REDIRECT:
      return {
        ...state,
        redirect: action.payload,
      };
    default:
      return state;
  }
}

export default redirectReducer;
