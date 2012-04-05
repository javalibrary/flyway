/**
 * Copyright (C) 2010-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.flyway.core.api.migration.jdbc;

import java.sql.Connection;

/**
 * <p>Interface to be implemented by Jdbc Java-based Migrations.</p>
 * <p>
 * By default the migration version and description will be extracted from the class name. This can be overriden by also
 * implementing the {@code MigrationInfoProvider} interface, in which case it can be specified programmatically.
 * </p>
 * <p>
 * The checksum of this migration (for validation) will also be {@code null}, unless the migration also implements the
 * {@code MigrationChecksumProvider}, in which case it can be returned programmatically.
 * </p>
 */
public interface JdbcMigration {
    /**
     * Executes this migration. The execution will automatically take place within a transaction, when the underlying
     * database supports it.
     *
     * @param connection The connection to use to execute statements.
     * @throws Exception when the migration failed.
     */
    void migrate(Connection connection) throws Exception;
}
