package bg.mobile.config.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

import static bg.mobile.config.security.SecurityConstants.HEADER_STRING;
import static bg.mobile.config.security.SecurityConstants.SECRET;
import static bg.mobile.config.security.SecurityConstants.TOKEN_PREFIX;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(final HttpServletRequest req,
                                    final HttpServletResponse res,
                                    final FilterChain chain) throws IOException, ServletException {
        final String header = req.getHeader(HEADER_STRING);

        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(req, res);
            return;
        }

        final UsernamePasswordAuthenticationToken authentication = getAuthentication(header);
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
        authentication.setAuthenticated(true);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(final String header) {
        final String user = JWT.require(Algorithm.HMAC512(SECRET.getBytes()))
                .build()
                .verify(header.replace(TOKEN_PREFIX, ""))
                .getSubject();

        if (user != null) {
            return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
        }
        return null;
    }
}