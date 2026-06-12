/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentorg;

/**
 *
 * @author easterPC
 */
public class Organization {
    private int orgId;
    private String orgName;
    private String description;

    // Constructor
    public Organization(int orgId, String orgName, String description) {
        this.orgId = orgId;
        this.orgName = orgName;
        this.description = description;
    }

    // Getters and Setters
    public int getOrgId() { return orgId; }
    public void setOrgId(int orgId) { this.orgId = orgId; }
    
    public String getOrgName() { return orgName; }
    public void setOrgName(String orgName) { this.orgName = orgName; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
