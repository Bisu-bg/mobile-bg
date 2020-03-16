import React, { useEffect, useState } from 'react';
import { Redirect } from 'react-router-dom';
// Redux
import { useSelector} from 'react-redux';

/** Redirect to pre-selected page */
function CustomRedirect() {
  /** Object which contains parameters to next page {pathname: ... , state: ...} */
  const { redirect } = useSelector(state => state.redirect);

  const [redirectPath, setRedirectPath] = useState(redirect);

  useEffect(() => {
    window.onpopstate  = (e) => {
      /** Detect browser back button and reset redirectPath */
      return setRedirectPath('')
      }
    /** Update redirectPath when the state from redux appear */
    setRedirectPath(redirect)
  }, [redirect])

  return redirectPath && redirectPath.destination ? (
    <Redirect
      push
      to={{
        pathname: redirectPath.destination,
        state: redirectPath.body,
      }}
    />
  ) : null;
}

export default CustomRedirect;
