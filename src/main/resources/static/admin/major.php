<?php
    header('Content-Type:application/json');
    $array = [
        'code'    => 0,
        'msg'     => '',
        'count'   => 5,
        'data'    =>[
            [
                'id'        => '1',
                'college'   => '车辆与能源学院',
                'major'     => ''],
            [
                'id'        => '2',
                'college'   => '',
                'major'     => '|—车辆工程'],
            [
                'id'        => '3',
                'college'   => '',
                'major'     => '|—能源与动力工程'],
            [
                'id'        => '4',
                'college'   => '计算机学院',
                'major'     => ''],
            [
                'id'        => '5',
                'college'   => '',
                'major'     => '|—软件工程']
        ]
    ];
    echo json_encode($array);