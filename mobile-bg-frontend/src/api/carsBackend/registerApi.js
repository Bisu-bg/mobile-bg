import axios from 'axios';
import { REGISTER_SERVICE_URL } from './config';

export const api = {
  register: async function(username,password,firstName,lastName) {
    return axios.post(REGISTER_SERVICE_URL, {
      firstName,
      lastName,
      password,
      username
    });
  },
};
