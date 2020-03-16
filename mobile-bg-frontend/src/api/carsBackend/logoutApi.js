export const api = {
  logout: async function(accessToken) {
    // axios.post(LOGOUT_SERVICE_URL, {}, {
    //   headers: {
    //     Authorization: 'Bearer ' + accessToken,
    //   },
    // });
    return new Promise(resolve => {
      resolve({data:{'Success':200}})
    });
  },
};
