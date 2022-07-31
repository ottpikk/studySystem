package com.sda.studysystem.handlers;

import com.sda.studysystem.utils.Constants;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * Custom handler to implement AuditorAware
 *
 * @author Ott Pikk
 */
public class AuditAwareHandler implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(Constants.Audit.DEFAULT_AUDITOR);
    }
}
