<?php
    header('Content-Type:application/json');
    $array = [
            'name'         => '开发部',
            'status'       => '1',
            'recruit'      => '1'
    ];

    echo json_encode($array);
