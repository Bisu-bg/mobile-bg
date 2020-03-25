import { REDIRECT } from './types';

 /**
   * Create action which redirect to given page.
   * @param {string} destination - Path to page example: '/home'
   * @param {object} [body] - This field is optional. You can pass props here 
   */
export function redirect(destination, body) {
  return {
      type: REDIRECT,
      payload: {
          destination,
          body
      }
  }
}
