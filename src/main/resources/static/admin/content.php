<?php
    header('Content-Type:application/json');
    $array = [
        'code'    => 0,
        'msg'     => '',
        'count'   => 6,
        'data'    => [
            [
                'id'            => 1,
                'cate'       => '通知公告',
                'title'            => '国家卫健委：新增本土确诊病例42例 其中河北40例',
                'status'             => 1,
                'sorting'            => 1,
                'update_time'      => date('Y-m-d H:i:s'),
                'create_time'   => date('Y-m-d H:i:s')],
            [
                'id'            => 1,
                'cate'       => '通知公告',
                'title'            => '国家卫健委：新增本土确诊病例42例 其中河北40例',
                'status'             => 1,
                'sorting'            => 2,
                'update_time'      => date('Y-m-d H:i:s'),
                'create_time'   => date('Y-m-d H:i:s')],
            [
                'id'            => 1,
                'cate'       => '通知公告',
                'title'            => '国家卫健委：新增本土确诊病例42例 其中河北40例',
                'status'             => 1,
                'sorting'            => 2,
                'update_time'      => date('Y-m-d H:i:s'),
                'create_time'   => date('Y-m-d H:i:s')],
            [
                'id'            => 1,
                'cate'       => '通知公告',
                'title'            => '国家卫健委：新增本土确诊病例42例 其中河北40例',
                'status'             => 1,
                'sorting'            => 4,
                'update_time'      => date('Y-m-d H:i:s'),
                'create_time'   => date('Y-m-d H:i:s')],
            [
                'id'            => 1,
                'cate'       => '通知公告',
                'title'            => '国家卫健委：新增本土确诊病例42例 其中河北40例',
                'status'             => 1,
                'sorting'            => 15,
                'update_time'      => date('Y-m-d H:i:s'),
                'create_time'   => date('Y-m-d H:i:s')],
            [
                'id'            => 1,
                'cate'       => '通知公告',
                'title'            => '国家卫健委：新增本土确诊病例42例 其中河北40例',
                'status'             => 1,
                'sorting'            => 19,
                'update_time'      => date('Y-m-d H:i:s'),
                'create_time'   => date('Y-m-d H:i:s')]
        ]
    ];

    echo json_encode($array);

