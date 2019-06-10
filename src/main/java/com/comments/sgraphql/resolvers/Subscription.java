package com.comments.sgraphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.comments.sgraphql.domain.Comment;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import javax.annotation.PostConstruct;

@Component
public class Subscription implements GraphQLSubscriptionResolver {
    private ConnectableFlux<Comment> publisher;
    private FluxSink<Comment> emitter;

    @PostConstruct
    public void init(){
        this.publisher = Flux
                .<Comment>create(emitter -> this.emitter = emitter)
                .share()
                .publish();

        this.publisher.connect();
    }

    public Publisher<Comment> onSaveComment(){
        return publisher;
    }

    public void onNextSaveComment(Comment comment){
        this.emitter.next(comment);
    }
}