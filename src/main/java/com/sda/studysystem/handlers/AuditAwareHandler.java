package com.sda.studysystem.handlers;

import com.sda.studysystem.utils.Constants;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

/**
 * Custom handler to implement AuditorAware
 *
 * @author Ott Pikk
 */
public class AuditAwareHandler implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }

        return userName.isEmpty() ? Optional.of(Constants.Audit.DEFAULT_AUDITOR) : Optional.of(userName);
    }
}
