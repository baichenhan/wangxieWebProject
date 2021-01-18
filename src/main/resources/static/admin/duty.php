<?php
    header('Content-Type:application/json');
    $array = [
        'code'    => 0,
        'msg'     => '',
        'count'   => 5,
        'data'    => [
            [
                'id'            => '1',
                'Mon'            => 'AAA',
                'Tue'       => 'BBB',
                'Wed'            => 'CCC',
                'Thu'          => 'DDD',
                'Fri'             => 'EEE',],
            [
                'id'            => '2',
                'Mon'            => 'AAA',
                'Tue'       => 'BBB',
                'Wed'            => 'CCC',
                'Thu'          => 'DDD',
                'Fri'             => 'EEE',],
            [
                'id'            => '3',
                'Mon'            => 'AAA',
                'Tue'       => 'BBB',
                'Wed'            => 'CCC',
                'Thu'          => 'DDD',
                'Fri'             => 'EEE',],
            [
                'id'            => '4',
                'Mon'            => 'AAA',
                'Tue'       => 'BBB',
                'Wed'            => 'CCC',
                'Thu'          => 'DDD',
                'Fri'             => 'EEE',],
            [
                'id'            => '5',
                'Mon'            => 'AAA',
                'Tue'       => 'BBB',
                'Wed'            => 'CCC',
                'Thu'          => 'DDD',
                'Fri'             => 'EEE',],

        ]
    ];

    echo json_encode($array);

