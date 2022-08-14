package com.sda.studysystem.handlers;

import com.sda.studysystem.utils.Constants;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

import static com.sda.studysystem.utils.Constants.Audit.DEFAULT_AUDITOR;

/**
 * Custom handler to implement AuditorAware
 *
 * @author Ott Pikk
 */
public class AuditAwareHandler implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null ? Optional.of(authentication.getName()) : Optional.of(DEFAULT_AUDITOR);
    }
}
