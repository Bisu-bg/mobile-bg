import axios from 'axios';
import { LOGIN_SERVICE_URL } from './config';

export const api = {
  login: async function(username, password) {
    return axios.post(LOGIN_SERVICE_URL, {
        username,
        password,      
    });
  },
};
