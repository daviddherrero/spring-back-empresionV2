package tfg.backend.empresion.service.mongosequences;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import tfg.backend.empresion.domain.DatabaseSequence;
import tfg.backend.empresion.domain.User;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class UserNextSequenceService {

    @Autowired
    private MongoOperations mongo;

    public int getNextUserId(String seqName){
        DatabaseSequence valorId = mongo.findAndModify(
                query(where("_id").is(seqName)),
                new Update().inc("seq",1),
                options().returnNew(true).upsert(true),
                DatabaseSequence.class);
        return !Objects.isNull(valorId) ? valorId.getSeq() : 1;
    }
}
