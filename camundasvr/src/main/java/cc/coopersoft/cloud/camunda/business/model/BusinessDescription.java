package cc.coopersoft.cloud.camunda.business.model;

import cc.coopersoft.common.json.JsonRawDeserializer;
import cc.coopersoft.common.json.JsonRawSerialize;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "BUSINESS_DESCRIPTION")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@NoArgsConstructor
@Access(AccessType.PROPERTY)
public class BusinessDescription extends cc.coopersoft.common.business.BusinessDescription<BusinessKey> {


    @Id
    @JoinColumn(name = "ID", unique = true, nullable = false)
    @Access(AccessType.FIELD)
    @JsonIgnore
    public Long id;

    @Column(name = "DESCRIPTION")
    @Access(AccessType.FIELD)
    private String description;

    @JsonDeserialize(using = JsonRawDeserializer.class)
    @JsonSerialize(using = JsonRawSerialize.class)
    @Column(name = "TAGS")
    @Access(AccessType.FIELD)
    private String tags;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "_KEYS", length = 1024)
    @JsonIgnore
    @Override
    public String getKeys(){return super.getKeys();}

    @Transient
    public Map<String, Object> getDescriptionMap(){
        return super.getDescriptionMap();
    }

    @Column(name = "PROCESS", nullable = false)
    @Override
    public boolean isProcess(){return super.isProcess();}

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id.description", cascade = CascadeType.ALL , orphanRemoval = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public Set<BusinessKey> getBusinessKeys(){return super.getBusinessKeys();}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        BusinessDescription that = (BusinessDescription) o;

        return id != null ? id.equals(that.id) : false;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : super.hashCode());
        return result;
    }
}
