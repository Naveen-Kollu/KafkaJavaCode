package com.example.Kafka.KafkaDemp;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.Properties;

import java.util.stream.Stream;

public class SimpleKafkaStream {

    private static final Logger logger = (Logger) LogManager.getLogger(SimpleKafkaStream.class);

    public static void main(String args[]){

        System.out.println("Enter into Streams Class");

        Properties prop = new Properties();
        prop.put(StreamsConfig.APPLICATION_ID_CONFIG,"mygroupId");
        prop.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        prop.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        prop.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.Integer().getClass());
        prop.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG,Serdes.String().getClass());

        StreamsBuilder streamBuilder =new StreamsBuilder();
        KStream <Object,Object> kstream = streamBuilder.stream("streamsTopic");

        System.out.println("this is message from Topic"+kstream.toString());
        System.out.println("this is message from group by key "+kstream.groupByKey());

        kstream.foreach((k,v) -> System.out.println("key value is "+ k +"value is "+ v));

        Topology topology = streamBuilder.build();


        logger.info("starting streams");
        KafkaStreams kfStream = new KafkaStreams(topology,prop);

        kfStream.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {

            logger.info("ending stream");
        } ));
        kfStream.close();

    }
}
