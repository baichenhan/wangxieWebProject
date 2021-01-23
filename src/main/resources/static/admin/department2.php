<?php
    header('Content-Type:application/json');
    $array = [
        'code'    => 0,
        'msg'     => '',
        'count'   => 4,
        'data'    => [
            [
                'id'          => 1,
                'name'        => '运维部',
                'status'      => '正常',
                'recruit'     => '正常'],
            [
                'id'          => 2,
                'name'        => '开发部',
                'status'      => '正常',
                'recruit'     => '正常'],
            [
                'id'          => 3,
                'name'        => '组宣部',
                'status'      => '正常',
                'recruit'     => '正常'],
            [
                'id'          => 4,
                'name'        => 'CTF部',
                'status'      => '正常',
                'recruit'     => '正常'],
        ]
    ];
    echo json_encode($array);