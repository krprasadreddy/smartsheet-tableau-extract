/**
 *    Copyright 2013 Smartsheet.com
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * 
 */
package com.smartsheet.platform.tableau.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Row {

    protected Long id;
    protected Long sheetId;
    protected Integer rowNumber;
    protected Integer parentRowNumber;
    protected Integer version;
    
    protected List<Cell> cells;
    protected List<Discussion> discussions;
    protected List<Attachment> attachments;
    protected List<Column> columns;
    protected Boolean locked = null;
    protected Boolean lockedForUser = null;
    protected Boolean expanded;
    
    String accessLevel;
    String sheetName;
    
    Long siblingId;
    Long parentId;
    Boolean toTop;
    Boolean toBottom;
    
    Calendar createdAt;
	Calendar modifiedAt;
    
    public Row() {
  	}

	public Long getId() {
        return id;	
    }

    public void setId(Long value) {
        this.id = value;
    }


    public List<Cell> getCells() {
        if (cells == null) {
            cells = new ArrayList<Cell>();
        }
        return this.cells;
    }

	public List<Discussion> getDiscussions() {
		return discussions;
	}

	public void setDiscussions(List<Discussion> discussions) {
		this.discussions = discussions;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public Long getSheetId() {
		return sheetId;
	}

	public void setSheetId(Long sheetId) {
		this.sheetId = sheetId;
	}

	public Integer getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(Integer rowNumber) {
		this.rowNumber = rowNumber;
	}

	public Integer getParentRowNumber() {
		return parentRowNumber;
	}

	public void setParentRowNumber(Integer parentRowNumber) {
		this.parentRowNumber = parentRowNumber;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public Boolean getLockedForUser() {
		return lockedForUser;
	}

	public void setLockedForUser(Boolean lockedForUser) {
		this.lockedForUser = lockedForUser;
	}

	public Calendar getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}

	public Calendar getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Calendar modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public String getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public Long getSiblingId() {
		return siblingId;
	}

	public void setSiblingId(Long siblingId) {
		this.siblingId = siblingId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Boolean getToTop() {
		return toTop;
	}

	public void setToTop(Boolean toTop) {
		this.toTop = toTop;
	}

	public Boolean getToBottom() {
		return toBottom;
	}

	public void setToBottom(Boolean toBottom) {
		this.toBottom = toBottom;
	}

	public Boolean getExpanded() {
		return expanded;
	}

	public void setExpanded(Boolean expanded) {
		this.expanded = expanded;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
