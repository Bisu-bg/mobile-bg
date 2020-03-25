import { combineReducers } from 'redux';
import redirectReducer from './redirectReducer';

// TODO:Import reducers 

/** Combine all reducers
 * @returns {Object} store
 */
export default function createReducer() {
  const rootReducer = combineReducers({
    // TODO: set reducers 
    redirect: redirectReducer,
  });
  return rootReducer;
}
