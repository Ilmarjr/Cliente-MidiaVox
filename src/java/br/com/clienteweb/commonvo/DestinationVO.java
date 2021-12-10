
package br.com.clienteweb.commonvo;

/**
 * @author Ilmar Macedo Alves Junior
 * @date 2021/12/10
 *
 */
public class DestinationVO {
    private String id;
    private String destination;

    public DestinationVO(){
        setId("");
        setDestination("");
    }
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }
}
