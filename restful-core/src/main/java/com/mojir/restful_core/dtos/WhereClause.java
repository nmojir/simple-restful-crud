package com.mojir.restful_core.dtos;

/**
 * Where clause is and object representing a condition of search.
 * It's used by abstract dao for searching behavior.
 * @author Navid
 *
 */
public class WhereClause {
	private String field;
    private String operator;
    private String parameterName;
    private Object value;
    private boolean parametric = true;

    public WhereClause() {
    }


    public WhereClause(String field) {
        this.field = field;
        parametric = false;
    }

 
    public WhereClause(String field, String operator, Object value) {
        this(field, operator, value, field);
    }


    public WhereClause(String field, String operator, Object value, String parameterName) {
        this.field = field;
        this.operator = operator;
        this.value = value;
        this.parameterName = parameterName;
        parametric = true;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public boolean isParametric() {
        return parametric;
    }

    public void setParametric(boolean parametric) {
        this.parametric = parametric;
    }
}
