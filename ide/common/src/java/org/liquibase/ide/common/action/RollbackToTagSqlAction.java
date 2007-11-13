package org.liquibase.ide.common.action;

import liquibase.exception.LiquibaseException;
import liquibase.migrator.Migrator;
import liquibase.database.Database;
import org.liquibase.ide.common.IdeFacade;

import java.io.StringWriter;

public class RollbackToTagSqlAction extends MigratorAction {

    public RollbackToTagSqlAction() {
        super("Rollback to Tag (Generate SQL)");
    }

    public void actionPerform(Database database, IdeFacade ideFacade) throws LiquibaseException {
        String input = ideFacade.promptForString(getTitle(), "Enter database tag to roll back to", null);
        if (input != null) {
            StringWriter writer = new StringWriter();
            ideFacade.getMigrator(database).rollbackSQL(input, writer);

            ideFacade.displayOutput("Rollback SQL", writer.toString());
        }
    }

}